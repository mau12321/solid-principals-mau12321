[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=16940500)
# Instructions for Refactoring the Provided Code: Applying the Single Responsibility Principle

In the provided code, the `Student` and `Assignment` classes are responsible for both data management and logic, which violates the **Single Responsibility Principle (SRP)**. Each class should have one focus. Here's how we can refactor the code to improve separation of concerns while allowing the `Assignment` class to handle grading.

### 1. Issues in the Current Code

#### `Student` Class:
- Manages student data like name, ID, courses, and assignments (correct responsibility).
- Also handles assignment submission and grading (incorrect, should be handled by `Assignment`).

#### `Assignment` Class:
- Manages assignment-related data like name, course name, etc.
- Should be responsible for grading logic rather than the `Student` class.

### 2. Refactoring Plan

We will:
- Move the grading logic to the `Assignment` class.
- Keep the `Student` class focused on managing student-related information (name, courses, assignments).
- Ensure the `Assignment` class determines the grade when a submission is made.

### 3. Refactored Code Outline

#### 3.1 `Student` Class
The `Student` class will now focus solely on managing:
- The student’s name and ID.
- The list of courses the student is enrolled in.
- The list of assignments.

We remove any grading logic from this class.

#### 3.2 `Assignment` Class
The `Assignment` class now takes full responsibility for grading. It will:
- Check whether the student's submission matches the rubric.
- Return a grade ("A" or "F") based on the comparison.

### 4. Benefits of Refactoring

#### Separation of Concerns:
- `Student` Class: Manages only student-related data (name, courses, assignments).
- `Assignment` Class: Handles the grading logic and assignment details.

#### Single Responsibility:
- The `Student` class no longer deals with grading.
- The `Assignment` class now takes full ownership of grading.

#### Encapsulation: 
- The rubric is kept private within the `Assignment` class, ensuring that grading logic remains internal.

---

# Instructions for Applying the Open/Closed Principle (OCP)

The **Open/Closed Principle (OCP)** states that classes should be open for extension but closed for modification. This means that the behavior of a class should be extendable (via inheritance or composition) without altering its existing code, reducing the risk of introducing bugs in the original implementation.

Let’s refactor the code to follow OCP.

### 1. Problem with Current Code

In the current code:
- The `Shape` class is designed to be extended by different shapes like `Circle` and `Rectangle`. However, it uses `UnsupportedOperationException` in the `area()` and `getName()` methods, which is problematic because:
  - These methods must be overridden by every subclass.
  - There’s no way to prevent `Shape` from being instantiated directly (though it wouldn’t make sense to do so).

### 2. Refactoring to Apply OCP

To adhere to OCP:
- **Step 1**: Modify the `Shape` class so that it cannot be instantiated directly and requires subclasses to provide their own implementations for `area()`. The `getName()` method can remain concrete.
- **Step 2**: Ensure `TotalAreaCalculator` works with any new shape without modification by leveraging polymorphism.

### 3. Refactored Code Outline

#### 3.1 `Shape` Class (Open for Extension, Closed for Modification)
Ensure that new shapes can be added without altering the `Shape` class. Use inheritance to prevent instantiation and only provide a method signature for `area()`.

#### 3.2 `Circle` Class
`Circle` extends `Shape` and provides its own implementation of `area()`.

#### 3.3 `Rectangle` Class
Similarly, `Rectangle` extends `Shape` and implements `area()` for rectangles.

#### 3.4 `TotalAreaCalculator` Class (Closed for Modification)
The `calculateTotalArea()` method should report the name and area of each shape in the list and the total area summed. After implementing this method, this class will be closed for modification.

### 4. Explanation of Open/Closed Principle in the Refactored Code
- **Open for Extension**: You can easily extend the `Shape` class by creating new subclasses (e.g., `Triangle`, `Square`) without altering existing code.
- **Closed for Modification**: The `Shape` class and `TotalAreaCalculator` do not need to be modified to support new shapes.

### 5. Benefits of Refactoring
- **Maintainability**: New shapes can be added without modifying existing code.
- **Extensibility**: Adding a `Triangle` only requires defining the new class and implementing `area()`.
- **Polymorphism**: `TotalAreaCalculator` is flexible and works with any shape because it depends on the `Shape` abstraction.

---

# Instructions for Applying the Liskov Substitution Principle (LSP)

The **Liskov Substitution Principle (LSP)** states that objects of a superclass should be replaceable with objects of its subclasses without altering the correct behavior of the program. In your code:

- Penguins cannot fly.
- Only African Swallows can carry coconuts.

### 1. Problem with the Current Code

In the original `Bird` class:
- Methods like `fly()`, `carryCoconut()`, and `swim()` are available to all bird subclasses, even though not all birds should perform these actions.
- This violates LSP because some birds would behave inappropriately when substituted for `Bird`.

### 2. Refactoring Plan

To adhere to LSP:
- Remove specific behaviors (such as flying, swimming, and carrying coconuts) from the base class `Bird`.
- Move behavior-specific methods into appropriate subclasses (`Penguin`, `AfricanSwallow`).

### 3. Refactored Code

#### 3.1 Base Class: `Bird`
The `Bird` class will contain only common behaviors like `layEgg()` and shared properties like `name` and `beakColor`.

#### 3.2 `AfricanSwallow` Class
The `AfricanSwallow` class extends `Bird` and provides `fly()` and `carryCoconut()` methods.

#### 3.3 `Penguin` Class
The `Penguin` class extends `Bird` and provides the `swim()` method.

#### 3.4 `BirdHabitat` Class
In `birdActivitiesReport()`, use `instanceof` to check which specific bird subclasses support actions like flying or swimming.

### 4. Explanation of Liskov Substitution Principle in the Refactored Code
- **LSP Adherence**: The base `Bird` class now only contains common behavior. Each subclass (`AfricanSwallow`, `Penguin`) provides only the behaviors that are valid for that specific bird.

### 5. Benefits of Refactoring
- **Adherence to LSP**: All subclasses of `Bird` behave as expected when substituted for the base `Bird` class.
- **Maintainability**: Easily add more bird types (e.g., a `Duck` that can swim and fly) by creating a new subclass with the correct behavior.

---

# Instructions for Implementing the Interface Segregation Principle (ISP)

The **Interface Segregation Principle (ISP)** states that clients should not be forced to depend on methods they do not use. In other words, instead of having one large interface with many methods that some classes might not need, we should split the interface into smaller, more specific ones.

### 1. Review of Interfaces

Three separate interfaces:
- `IFax` for faxing documents.
- `IPrint` for printing documents.
- `IScan` for scanning documents.

### 2. Implementing ISP in the `BasicPrinter` Class
`BasicPrinter` should only implement the `IPrint` interface because it only prints.

### 3. Implementing ISP in the `MultiFunctionPrinter` Class
`MultiFunctionPrinter` should implement all three interfaces: `IPrint`, `IScan`, and `IFax`.

### 4. Summary of How ISP is Applied
Each class only implements the functionality it needs, making the design cleaner and easier to understand.

### 5. Benefits of Applying ISP
- **Separation of Concerns**: Each class only implements what it needs.
- **Flexibility**: New functionality can be added by creating new interfaces.
- **Ease of Maintenance**: Each class has a smaller, more focused role.

---

# Instructions for Implementing the Dependency Inversion Principle (DIP)

The **Dependency Inversion Principle (DIP)** states that:
1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
2. Abstractions should not depend on details.

### 1. Review of Provided Code

In the code:
- **High-level module**: `MessageProcessor`.
- **Low-level modules**: `EmailService` and `SmsMessageService`.

### 2. Refactoring to Apply the Dependency Inversion Principle

The goal is to ensure that `MessageProcessor` depends on the `IMessageService` interface, allowing flexibility in message delivery without depending on specific implementations.

### 3. Explanation of the Dependency Inversion Principle in the Refactored Code
- **DIP Adherence**: `MessageProcessor` only depends on `IMessageService`, meaning it doesn’t care about how messages are sent.

### 4. Benefits of Applying DIP
- **Loose Coupling**: `MessageProcessor` doesn’t depend on concrete classes.
- **Extendability**: You can add new message services (e.g., `PushNotificationService`) without modifying existing code, promoting flexibility and scalability.
- **Testability**: Since `MessageProcessor` depends on an interface (`IMessageService`), it's easier to mock or stub message services during unit testing.

---

### 5. Summary

The Dependency Inversion Principle was applied by ensuring that:

- High-level modules (`MessageProcessor`) depend on abstractions (`IMessageService` interface), not on concrete classes.
- Low-level modules (`EmailService`, `SmsMessageService`) implement the abstraction (`IMessageService`), allowing them to be easily swapped or extended without affecting the high-level logic in `MessageProcessor`.

