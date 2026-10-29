package pl.bsjhx.katas.designpatterns.composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DirectoryTest {

    private Directory directory;

    @BeforeEach
    void setUp() {
        directory = Directory.directory("Test subject");
    }

    @Test
    void should_print_directory() {
        directory.add(File.file("file1.txt", 100));
        directory.add(File.file("file2.txt", 500));
        directory.add(File.file("file3.txt", 200));

        assertThat(directory.print("")).isEqualTo(
                """
                Test subject/
                \tfile1.txt (100 bytes)
                \tfile2.txt (500 bytes)
                \tfile3.txt (200 bytes)""");

        var secondDirectory = Directory.directory("Second directory");
        secondDirectory.add(File.file("file4.txt", 100));
        secondDirectory.add(File.file("file5.txt", 500));
        directory.add(secondDirectory);

        assertThat(directory.print("")).isEqualTo(
                """
                Test subject/
                \tSecond directory/
                \t\tfile4.txt (100 bytes)
                \t\tfile5.txt (500 bytes)
                \tfile1.txt (100 bytes)
                \tfile2.txt (500 bytes)
                \tfile3.txt (200 bytes)""");
    }

    @Test
    void should_return_proper_sizes() {
        directory.add(File.file("file1.txt", 100));
        directory.add(File.file("file2.txt", 500));
        directory.add(File.file("file3.txt", 200));

        assertThat(directory.getSize()).isEqualTo(800);

        var secondDirectory = Directory.directory("Second directory");
        secondDirectory.add(File.file("file4.txt", 100));
        secondDirectory.add(File.file("file5.txt", 500));
        directory.add(secondDirectory);

        assertThat(directory.getSize()).isEqualTo(1400);
    }

    @Test
    void directory_should_be_able_to_remove_elements() {
        directory.add(File.file("file1.txt", 100));
        directory.add(File.file("file2.txt", 500));
        directory.add(File.file("file3.txt", 200));

        assertThat(directory.getSize()).isEqualTo(800);

        var secondDirectory = Directory.directory("Second directory");
        secondDirectory.add(File.file("file4.txt", 100));
        secondDirectory.add(File.file("file5.txt", 500));
        directory.add(secondDirectory);

        assertThat(directory.getSize()).isEqualTo(1400);

        directory.remove(File.file("file3.txt", 200));
        assertThat(directory.getSize()).isEqualTo(1200);

        directory.remove(Directory.directory("Second directory"));

        assertThat(directory.getSize()).isEqualTo(600);
    }
}