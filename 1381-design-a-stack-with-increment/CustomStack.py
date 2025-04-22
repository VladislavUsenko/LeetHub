class CustomStack:

    def __init__(self, maxSize: int):
        self.stack = [0] * maxSize
        self.index = -1

    def push(self, x: int) -> None:
        if self.index < len(self.stack) - 1:
           self.index += 1
           self.stack[self.index] = x 
        

    def pop(self) -> int:
        if self.index < 0:
            return -1
        
        val = self.stack[self.index]
        self.index -= 1
        return val
        

    def increment(self, k: int, val: int) -> None:
        size = min(self.index, k - 1)

        for i in range(size + 1):
            self.stack[i] += val
        
stack = CustomStack(3)
stack.push(1)
stack.push(2)

print(stack.stack, stack.index)

stack.pop()
stack.push(2)
stack.push(3)
stack.push(4)

print(stack.stack, stack.index)

stack.increment(5, 100)
stack.increment(2, 100)

print(stack.stack, stack.index)

stack.pop()
stack.pop()
stack.pop()
stack.pop()

print(stack.stack, stack.index)

# Your CustomStack object will be instantiated and called as such:
# obj = CustomStack(maxSize)
# obj.push(x)
# param_2 = obj.pop()
# obj.increment(k,val)