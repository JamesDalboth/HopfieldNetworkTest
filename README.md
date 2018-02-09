# HopfieldNetworkTest

This is a rough implementation for a Discrete Asynchronous hopfield network.

# Representation

In a hopfield network there is only one layer of nodes.

Nodes are also discrete in this example therefore they can only output (-1,1)

This makes it perfect to represent our single layer of nodes as a vector X where each value of X representes the value of a node.

We then need a matrix to represent the weights between nodes. In a hopfield network, the output of nodes become the inputs of themselves. If we represent a weight between node i and node j like Wij there are a couple rules we must follow when making our weight matrix

1. wij = wji (the matrix is symetrical)
2 wii = 0 (no node connects to itself)

# Training

Lets say we have a pattern we wish to train out network on X' To calculate our weight matrix we do as follows:

W = (X'T)X - I

X'T means the transpose of X.
I is the identity matrix

Then thats all we have to do if we want one data to train off


if we have multiple pieces of data we want to train we can do as follows

if we have data X1 X2 and X3 we can combine the vectors in a matrix X'.

Then use this equation

W = (X'T)X - mI

m represents the number of training vectors. The whole purpose of -I is to make the diagonal 0. Now we have multiple vectors the diagonal will be m so we must times the identity by m before subtracting it to make the diagonal zero 

(NOTE in this implementation i just manually set the diagonal to zero)


# Running asynchronously

there are 2 methods of running this network, in this version ive choosen asynchronusly.

Essentially we go through each node,

lets say were at node i

the nodes new value will be WiX

where Wi represents the ith row of the weight matrix


# Running Synchronously

This time we simply say the state of the nodes at time t is Xt and we get

Xt+1 = WXt

This is much simpler and easier to implement. The effects are normally less great though.
