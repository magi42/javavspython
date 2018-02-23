'''
This example demonstrates how a simple change in return value can generate
an error.

We simply change a floating-point return value to an integer. Then, we
fix the dependent functions to use that value. The problem is that
since there's no type checking, you easily forget to change all the
dependents. 


Created on 23.2.2018

@author: magi
'''

def returnAValue():
    """Return 21."""
    # return 21
    return (21, "hello")  # <-- Change to this

def multiplyByTwo1():
    """Divide by two.
    
    Returns a floating-point value.
    """
    # return returnAValue() * 2  # <-- No longer valid so need to change
    (val, s) = returnAValue()
    return (val * 2, s)

def mainFunction():
    """Do some calculation."""
    print multiplyByTwo1(), multiplyByTwo2()  # <- defined elsewhere (scroll down)













































def multiplyByTwo2():
    return returnAValue() * 2  # <-- FORGET to change this

if __name__ == '__main__':
    mainFunction()
