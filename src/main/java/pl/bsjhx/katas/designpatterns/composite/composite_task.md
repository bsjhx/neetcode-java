# Design Pattern Exercise: Composite — File System Explorer

## Goal

Implement a simplified file system explorer using the **Composite** design pattern.

The goal is to represent individual files and directories through a common abstraction, allowing clients to perform operations on both individual objects and groups of objects uniformly.

## Business Context

You are building a component for a file management application.

The application represents a file system containing:
- Files, which store content and have a size.
- Directories, which contain files and other directories.

Directories can be nested to any depth. The application must calculate the total size of a directory, including all its nested contents, without requiring the client to distinguish between files and directories.

## Functional Requirements

### 1. File System Elements

Create a common abstraction for all file system elements.

Every element must support the following operations:

- `getName()` — returns the element's name.
- `getSize()` — returns the element's size in bytes.
- `print(String indentation)` — prints the element and its contents in a readable tree structure.

### 2. Files

Implement a `File` class.

Each file must have:
- A name.
- A size in bytes.

Requirements:
- A file is a leaf element and cannot contain other elements.
- `getSize()` returns the file's own size.
- `print(String indentation)` prints the file's name and size.

Example output:

```text
report.pdf (2048 bytes)
```

### 3. Directories

Implement a `Directory` class.

Each directory must have:
- A name.
- A collection of child file system elements.

Requirements:
- A directory can contain files and other directories.
- `add(FileSystemElement element)` adds a child element.
- `remove(FileSystemElement element)` removes a child element.
- `getSize()` returns the total size of all direct and indirect descendants.
- `print(String indentation)` prints the directory and recursively prints its contents.

Example output:

```text
documents/
  report.pdf (2048 bytes)
  archive/
    old-report.pdf (1024 bytes)
```

The size of `documents/` in this example is `3072` bytes.

### 4. Uniform Client Interface

The client must be able to work with files and directories through the same abstraction.

For example:

```java
FileSystemElement file =
        new File("report.pdf", 2048);

FileSystemElement directory =
        new Directory("documents");

System.out.println(file.getSize());
System.out.println(directory.getSize());
```

The client must not need to check whether an element is a file or a directory to calculate its size or print its contents.

### 5. Example File System

Create the following structure:

```text
root/
  documents/
    report.pdf (2048 bytes)
    notes.txt (1024 bytes)
  images/
    logo.png (4096 bytes)
  readme.md (512 bytes)
```

Expected total size of `root/`:

`7680 bytes`

Your implementation must produce the correct total size and print the complete hierarchy.

## Design Requirements

1. Use the **Composite** design pattern.
2. Define a common abstraction for both files and directories.
3. Model `File` as a leaf and `Directory` as a composite.
4. A composite must store child elements through the common abstraction, not through concrete `File` or `Directory` types.
5. Directory operations must work recursively for nested directories.
6. Client code must not use `instanceof`, type checks, or conditional logic to distinguish between files and directories.
7. Do not create separate size-calculation logic in the client for files and directories.
8. Prevent invalid operations where practical, such as adding a directory to itself or creating a circular directory structure.
9. Follow SOLID principles, particularly the Open/Closed Principle.

## Technical Requirements

- Java 17 or later
- No external dependencies
- No frameworks required
- Use interfaces or abstract classes where appropriate
- Use collections from the Java standard library
- Keep the implementation focused on the design pattern rather than infrastructure

## Expected Client Usage

The following is an example of the intended usage, not a prescribed implementation:

```java
Directory root = new Directory("root");

Directory documents = new Directory("documents");
Directory images = new Directory("images");

documents.add(new File("report.pdf", 2048));
documents.add(new File("notes.txt", 1024));

images.add(new File("logo.png", 4096));

root.add(documents);
root.add(images);
root.add(new File("readme.md", 512));

System.out.println(root.getSize());
root.print("");
```

The client should interact with the root directory without needing to know how many levels of nesting exist.

## Acceptance Criteria

- [ ] Files and directories share a common abstraction.
- [ ] Files return their own size.
- [ ] Directories return the recursive total size of their contents.
- [ ] Directories can contain both files and other directories.
- [ ] Files cannot contain child elements.
- [ ] Printing produces a readable hierarchical tree.
- [ ] The example file system reports a total size of `7680` bytes.
- [ ] Client code does not distinguish between files and directories using type checks.
- [ ] Circular directory structures are prevented.
- [ ] Adding a new kind of file system element does not require modifying the existing directory implementation, provided it follows the common abstraction.

## Testing Requirements

Write tests covering:

- A file's size.
- An empty directory's size.
- A directory containing multiple files.
- A directory containing nested directories.
- Removing an existing child.
- Printing a nested hierarchy.
- Attempting to create a circular directory structure.
- Calculating the size of the example file system.

Use JUnit if you want to add a testing dependency. Otherwise, a simple executable test class is sufficient.

## Stretch Goals

1. Add `getFileCount()`, returning the total number of files inside a directory, including nested directories.
2. Add an operation that searches for an element by name.
3. Prevent duplicate child names within the same directory.
4. Introduce an operation that returns all file paths relative to the root directory.
5. Consider whether `remove()` should use object identity or element equality and document your decision.

## Definition of Done

The implementation is complete when all acceptance criteria are satisfied and the client can operate on individual files and arbitrarily nested directories through the same abstraction.