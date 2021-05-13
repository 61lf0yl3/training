# checkStraightLine
def checkStraightLine(self, coordinates: [[int]]) -> bool:
    if len(coordinates)==2: return True
    
    x1 = coordinates[0][0]
    y1 = coordinates[0][1]
    
    x2 = coordinates[1][0]
    y2 = coordinates[1][1]
    
    xsub = x2 - x1
    ysub = y2 - y1
    
    for i in range(len(coordinates)):
        if i >= 2:
            x = coordinates[i][0]
            y = coordinates[i][1]
            if x1 != x2 and y != (((x-x1)*ysub)/xsub)+y1: return False
            if x1 == x2 and x!=x1: return False
    return True
