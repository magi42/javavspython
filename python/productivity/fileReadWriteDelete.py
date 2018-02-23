'''
Created on 21.2.2018

@author: magi
'''
from os.path import os


def deleteFile(filename):
    """Delete a file gracefully, first checking that it exists."""
    if os.path.exists(filename) and os.path.isfile(filename):
        os.remove(filename)
        # Notice that handling the possible IOExcept is not forced

def writeFile(filename):
    """Create a file and write some data into it."""
    # Create some data
    array = [1,1]
    for i in range(2, 101):
        array.append(array[i-1] + array[i-2])
    
    # Open the file for writing
    out = open(filename, "w")
    
    # Write the data to the file
    for item in array:
        out.write("number=%d\n" % (item))
    
    out.close()

def readFile(filename):
    """Read a file and process the data in it."""
    pass

if __name__ == '__main__':
    filename = "testfile.txt"
    deleteFile(filename)
    writeFile(filename)
    readFile(filename)
    deleteFile(filename)
