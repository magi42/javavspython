'''
This example code demonstrates various situations where there
is no error whatsoever displayed in Eclipse.

Many actually give an error when actually compiling to .pyc,
but not in the Eclipse IDE

Created on 21.2.2018

@author: magi
'''

def stringFunction():
    """Return a string (really not)."""
    return 5

def intFunction():
    """Does not return a value while promised to do so."""
    return

class MyClass:
    def __init__(self):
        self.someProperty = 42
    
    def aMethod(self):
        pass


if __name__ == '__main__':
    myObject = MyClass()
    
    # No error: Calling a method with an invalid name
    # But, PYC compile time error is thrown.
    myObject.aMethodCall()
    
    # No error: Referencing a property with invalid name
    # But, PYC compile time error is thrown.
    print myObject.someProperti
    
    # No error: It's totally OK to do the following:
    myObject.somePropertah = 5
    
    # No error: It's totally OK to use different data type
    myObject.someProperty = "a string value"
    
    # No error: It's really
    print "%s" % (stringFunction())
    
    # Here we actually get errors:
    print nonexistingVariable
    nonexistingFunktion()

