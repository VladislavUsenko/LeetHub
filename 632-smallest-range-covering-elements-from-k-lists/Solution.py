import heapq

def smallestRange(nums):
    heap = []
    current_max = float('-inf')

    # Initialize heap and current_max
    for i, lst in enumerate(nums):
        val = lst[0]
        heapq.heappush(heap, (val, i, 0))
        current_max = max(current_max, val)

    range_start, range_end = 0, float('inf')

    while True:
        min_val, list_idx, elem_idx = heapq.heappop(heap)

        # Update the range if it's smaller than current best
        if current_max - min_val < range_end - range_start:
            range_start, range_end = min_val, current_max

        # Stop if this list is exhausted
        if elem_idx + 1 == len(nums[list_idx]):
            break

        # Push next element from the same list
        next_val = nums[list_idx][elem_idx + 1]
        heapq.heappush(heap, (next_val, list_idx, elem_idx + 1))
        current_max = max(current_max, next_val)

    return [range_start, range_end]


# Example usage
nums = [
    [4, 10, 15, 24, 26],
    [0, 9, 12, 20],
    [5, 18, 22, 30]
]

print(smallestRange(nums))  # Output: [20, 24]
