class Rectangle(object):
    
    def __init__(self, width, height):
        '''Initializes a Rectangle object 
        with width and height attributes
        '''
        self.width = width
        self.height = height
        
    def set_width(self, newWidth):
        '''Sets width to newWidth argument
        '''
        self.width = newWidth
    
    def set_height(self, newHeight):
        '''Sets height to newHeight argument
        '''
        self.height = newHeight
        
    def get_area(self): 
        '''Calculates and returns area based on 
        width and height attributes
        '''
        return self.width * self.height
    
    def get_perimeter(self): 
        '''Calculates and returns perimeter based on 
        width and height attributes
        '''
        return 2 * self.width + 2 * self.height
    
    def get_diagonal(self): 
        '''Calculates and returns diagonal based on 
        width and height attributes
        '''
        return (self.width**2 + self.height**2)**.5
    
    def get_picture(self): 
        '''Returns string of asterisks based on 
        width and height attributes
        
        If width or height is greater than 50, 
        returns 'Too big for picture.'
        '''
        if self.height > 50 or self.width > 50: 
            return 'Too big for picture.'
        lines = ''
        for i in range(self.height):
            lines = lines + self.width * '*' + '\n'
        return lines
    
    def get_amount_inside(self, shape): 
        '''Takes another shape as an argument and returns
        number of times this passed in shape can fit in the shape
        '''
        return self.get_area() // shape.get_area()
    
    def __str__(self):
        '''Returns string formatted to show name of object 
        and width and height attributes
        '''
        return 'Rectangle(width={}, height={})'.format(self.width, self.height)
    
class Square(Rectangle):
    
    def __init__(self, side): 
        '''Initializes Rectangle object with side attribute as 
        width and height
        '''
        Rectangle.__init__(self, side, side)
    
    def set_side(self, newSide):
        '''Sets width and height to newSide argument
        '''
        Rectangle.set_width(self, newSide)
        Rectangle.set_height(self, newSide)
        
    def __str__(self):
        '''Returns string formatted to show name of object 
        and side attribute'''
        return 'Square(side={})'.format(self.width)