## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## How to Run Any Java File Using the Batch Script

### 1. Update the Script Name
Open the `run.bat` file in a text editor (like Notepad or VS Code). You will see the following lines:

```batch
if not exist "bin" (
    mkdir bin
)
javac -d bin src/Exercise6.java && java -cp bin Exercise6
```

Replace both words of `Exercise6` with the name of the Java file you want to run. For example, to run `Exercise1`, update the lines to:

```batch
javac -d bin src/Exercise1.java && java -cp bin Exercise1
```

> **Note**: Make sure to save the file after making your changes.

### 2. Execute the Script

1. Open your `terminal` or `Git Bash` directly inside the project's **root folder** (the directory containing `run.bat`).

2. Type the following command:
   ```
   .\run.bat
   ```

3. Press **Enter** to compile and run your code.
