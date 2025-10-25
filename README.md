# Smart City Route Planner

A small Java project for the Data Structures & Algorithms course (semester project). This repository contains a simple route-planning application that demonstrates graph-based location management and route operations. The code is intentionally compact and intended for learning, demonstration, and extension.

## Table of contents

- Project overview
- Features
- Tech stack
- Project structure
- How to compile & run (Windows PowerShell)
- Members
- Notes & next steps

## Project overview

This project models a city map using basic data structures (graph and location tree) and includes a `Main` entrypoint to exercise functionality such as building the map and performing route-related operations. It is written in plain Java and requires a JDK to compile and run.

## Features

- City/Location management utilities
- Graph data structure for representing roads/paths
- Location tree helper data structure
- A `Main` class that runs sample operations (see source for details)

## Tech stack

- Java (JDK 8+ recommended)
- No external libraries required

## Project structure

Top-level files and purpose:

- `README.md` — This file.
- `src/CityManager.java` — City and location management logic.
- `src/Graph.java` — Graph data structure and related algorithms.
- `src/LocationTree.java` — Tree-based helper for locations.
- `src/Main.java` — Program entry point; demonstrates usage.

The `src` folder contains all Java source files in the default package.

## How to compile & run (Windows PowerShell)

Open PowerShell and run the following commands from the project root (where this `README.md` sits):

```powershell
# Change to the project directory (example)
cd "E:\IT\DSA\Smart-City-Route-Planner-main"

# Create an output directory for compiled classes
if (-not (Test-Path -Path .\bin)) { New-Item -ItemType Directory -Path .\bin | Out-Null }

# Compile all Java sources into the bin folder
javac -d bin src\*.java

# Run the program (Main is in the default package)
java -cp bin Main
```

Notes:

- If compilation fails, make sure you have a JDK installed and `javac` is on your PATH. You can check with `javac -version` and `java -version`.
- If your IDE manages compilation (Eclipse/IntelliJ), simply import the project as a plain Java project and run `Main`.

## Members

- Member 01 - 22UG3-0073 - J. A. C. N. Senarathna
- Member 02 - 22UG3-0713 - A. B. Sanduni Kawshalya Adahasingha
- Member 03 - 22UG3-0069 - W. J. S.Savinda Perera
- Member 04 - 22UG3-0812 - E. K. Udayangi Udeshika

## Notes & next steps

- This README focuses on getting started quickly. Suggested improvements:
  - Add usage examples and sample input/output for the `Main` run.
  - Add unit tests for graph algorithms.
  - Provide Javadoc comments and generate API docs.

If you'd like, I can also:

- Add a simple sample input file and modify `Main` to read it.
- Add a small test harness or Gradle/Maven build file.

---

Generated/updated on: 2025-10-25


