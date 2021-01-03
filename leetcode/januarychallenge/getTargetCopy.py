# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def getTargetCopy(self, original: TreeNode, cloned: TreeNode, target: TreeNode) -> TreeNode:
        if original == None :
            return None
        if original == target :
            return cloned
        left = getTargetCopy(original.left, cloned.left, target)
        right = getTargetCopy(original.right, cloned.right, target)
        if left == None:
            return right
        if right == None:
            return left