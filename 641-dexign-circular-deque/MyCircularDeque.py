from collections import deque


class MyCircularDeque:

    def __init__(self, k: int):
        self.queue = deque()
        self.k = k     

    def insertFront(self, value: int) -> bool:
        if len(self.queue) == self.k:
            return False
        else:
            self.queue.appendleft(value)
            return True
        

    def insertLast(self, value: int) -> bool:
        if len(self.queue) == self.k:
            return False
        else:
            self.queue.append(value)
            return True
        

    def deleteFront(self) -> bool:
        if self.queue:
            self.queue.popleft()
            return True
        else:
            return False
        

    def deleteLast(self) -> bool:
        if self.queue:
            self.queue.pop()
            return True
        else:
            return False
        

    def getFront(self) -> int:
        if self.queue:
            return self.queue[0]
        else:
            return -1

    def getRear(self) -> int:
        if self.queue:
            return self.queue[len(self.queue)-1]
        else:
            return -1

    def isEmpty(self) -> bool:
        return len(self.queue) == 0

    def isFull(self) -> bool:
        return len(self.queue) == self.k