# ShipApi

# Creational Patterns

## Factory method

### Intent

Factory Method is a creational design pattern that provides an interface for creating objects in supperclass, but allows subclasses to alter the type of objects that will be created.

### Problem

Imagine that you’re creating a logistics managment application. Most your code is coupled with **Truck** class. After some time you need to add **Ship** class. It will require to make changes to the entire codebase. You will end up with a nasty code ,riddled with with conditionals that will switch the app’s behavior depending on the class of transportation objects.

### Solution

The idea is to replace direct object construction calls(new operator) with calls to a special **factory method**. Creation with new operator still happend within a factory method. Obejcts returned by factory method are often referred to as ***products*.**
