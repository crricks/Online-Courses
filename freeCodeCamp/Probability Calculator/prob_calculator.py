import copy
import random

class Hat(object):
    
    def __init__(self, **kwargs):
        '''
        Compile self.contents list from kwargs

        '''
        self.contents = self.createHatContents(**kwargs)
        
    def createHatContents(self, **kwargs):
        contents = []
        for color, amount in kwargs.items():
            for num in range(amount):
                contents.append(color)
        return contents
    
    def draw(self, num_balls):
        '''
        Specifies number of balls to be drawn
        
        Returns a list of random balls drawn from contents

        '''
        if num_balls >= len(self.contents):
            return self.contents
        chosen = []
        for ball in range(num_balls):
            choice = random.choice(self.contents)
            chosen.append(choice)
            self.contents.remove(choice)
        return chosen

def experiment(hat, expected_balls, num_balls_drawn, num_experiments):
    # Set total positive experiments to 0
    total = 0
    # Get amount of balls expected
    expectedAmount = sum(expected_balls.values())
    
    # Iterate over number of experiments
    for e in range(num_experiments):
        # Set amount of balls that are both in expected and drawn to 0
        count = 0
        # Get deep copy of hat object then get draw
        hatCopy = copy.deepcopy(hat)
        drawn = hatCopy.draw(num_balls_drawn)
        # Iterate over the expected balls dictionary
        for ball, amount in expected_balls.items():
            for num in range(amount):
                # If expected ball in drawn, remove ball from drawn and add to count
                if ball in drawn:
                    drawn.remove(ball)
                    count += 1
        # If balls in drawnCopy equals amount of balls expected, add to positive experiments
        if count == expectedAmount: 
            total += 1
    # Return probability
    return total / num_experiments   