class MyQueue:

    def __init__(self):
        self.lst=[]

    def push(self, x: int) -> None:
        self.lst.append(x)

    def pop(self) -> int:
        return self.lst.pop(0)     

    def peek(self) -> int:
        return self.lst[0]

    def empty(self) -> bool:
        return len(self.lst)==0
