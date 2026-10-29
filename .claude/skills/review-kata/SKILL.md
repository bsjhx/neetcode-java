---
name: review-kata
description: Review a design pattern (or algorithm) kata implementation against its task description. Produces a structured report: what works well, task-specific issues/gaps, technical Java issues, and optional suggestions for stretch work. Triggers on "review kata", "review task", "review my implementation", "/review-kata".
---

# Review Kata

You are reviewing a kata implementation. The user has a task description (TASK.md or similar) and one or more implementation files.

## How to Gather Context

If the user has not already shown you the files, read:
1. The task description file (TASK.md, task.md, *_task.md, or whatever they point you to).
2. All implementation files relevant to the kata (search the package/directory).

Do not ask the user to paste code — read it yourself.

## Review Structure

Produce the review in exactly these four sections, in this order. Use the section headers below verbatim.

---

### What Works Well

List things the implementation gets right. Be specific — name classes, methods, design decisions. Minimum two points; more if warranted. Do not pad with generic praise.

---

### Issues / Gaps (Task Compliance)

Things that deviate from, or are missing relative to, the task description. Every point here must be traceable to a concrete requirement, acceptance criterion, design requirement, or expected output in the task file.

For each issue:
- State what the task requires.
- State what the implementation does instead (or omits).
- If the fix is short, show it inline.

If nothing is missing, write "None — all task requirements are satisfied."

---

### Technical Issues (Java / General Code Quality)

Problems unrelated to the task spec: wrong Java idioms, misuse of language features, naming that violates conventions, unnecessary complexity, missing null/edge-case handling that would matter in production, etc.

For each issue include the file and line number where possible.

If none found, write "None."

---

### Suggestions (Beyond the Task)

Ideas the user could pursue to deepen their understanding or extend the solution. These are optional — not required by the task. Frame them as options, not corrections.

- Prioritise suggestions that connect directly to the pattern or concept being practised.
- Include stretch goals from the task if they were not implemented.
- Limit to 3–5 focused suggestions; do not list every possible improvement.

---

## Tone and Style

- Be direct and specific. No vague observations.
- Do not repeat the task requirements back at length — reference them briefly.
- Keep "What Works Well" genuine; do not inflate it.
- "Issues / Gaps" is strictly about the task spec. Do not put Java style problems here.
- "Technical Issues" is strictly about code quality, not spec compliance. Do not put missing features here.
- Use code snippets where they make a point clearer, but keep them short.
