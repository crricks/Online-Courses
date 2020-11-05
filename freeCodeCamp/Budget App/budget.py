class Category(object):
    def __init__(self, name):
        '''Initializes a Category object
        
        a Category object has one attribute: 
            self.ledger (list)
        '''
        self.name = name
        self.ledger = []
        self.funds = 0
    
    def get_ledger(self):
        ''' 
        Used to safely access self.ledger outside of the class
        
        Returns: self.ledger
        '''
        return self.ledger
    
    def check_funds(self, amount):
        '''
        Updates funds through deposit and withdrawal method
        
        Input: amount (integer)
        
        Returns: True if able to withdraw, False if insufficient funds
        '''
        if amount > self.funds:
            return False
        else:
            return True
    
    def deposit(self, amount, description=''):
        '''
        Creates a dictionary and adds to ledger line item
        Updates funds
        
        Input: amount (int), description (string)
        '''
        self.ledger.append({'amount': amount, 'description': description})
        self.funds += amount
        
        
    def withdraw(self, amount, description=''):
        '''
        Creates a dictionary and adds to ledger line item, amount passed stored as negative
        
        Input: amount (int), description (string)
        
        Returns: True if ledger updated and amount withdrawn, False if insuffient funds
        '''
        if self.check_funds(amount):
            self.ledger.append({'amount': -amount, 'description': description})
            self.funds -= amount
            return True
        else:
            return False
    
    def get_balance(self):
        '''
        Returns funds based on deposits and withdrawals
        '''
        return self.funds
    
    def transfer(self, amount, category):
        '''
        Transfers an amount from current category to another category
        
        Input: amount (int), category (string)
        
        Returns: True if sufficient funds to do so, False if not
        '''
        description = 'Transfer to {}'.format(category.name)
        if self.withdraw(amount, description):
            descriptionTo = 'Transfer from {}'.format(self.name)
            category.deposit(amount, descriptionTo)
            return True
        else:
            return False
        
    def __str__(self):
        items = ''
        for i in self.ledger: 
            items = items + '\n' + '{:<23}{:>7.2f}'.format(i['description'][:23], i['amount'])  
        return self.name.center(30, '*') + items + '\nTotal: ' + str(self.funds)
        
def create_spend_chart(categories):
    '''
    Input: list of categories
    Output: string representing bar chart
    
    Bar chart shows percentage spent in each category
    '''
    # Create empty list to store negative amounts, set total and counter to zero
    items = []
    total = 0
    count = 0
    for category in categories: 
        count += 1
        spending = 0
        for i in category.get_ledger(): 
            if i['amount'] < 0: 
                spending += i['amount']
                total += spending
        items.append(spending)
    
    # Calculate averages and longest category.name string 
    avgs = [int((numb/total)*10) for numb in items]
    biggest = max(len(category.name) for category in categories)
    width = 3*count
    
    # Start with y-axis in list
    compilation = ['100| ', '90| ', '80| ', '70| ', '60| ', '50| ', 
             '40| ', '30| ', '20| ', '10| ', '0| ']
    
    # Iterate over the averages
    for avg in avgs:
        # Calculate spaces above 'o's
        spaces = 10 - avg
        # Iterate and add spaces to each y-axis label
        for space in range(spaces): 
            compilation[space] += '   '
        # Iterate and add o's to each y-axis label
        for o in range(spaces, 11): 
            compilation[o] += 'o  '
    
    # Add x-axis
    compilation.append('-'*(1+width))
    
    # Compile bottom portion in empty list with empty strings for each row
    bottom = []
    for i in range(biggest): 
        bottom.append('')
    
    # Iterate over categories and add to empty strings for each row
    for category in categories: 
        # Adding letters
        for i in range(len(category.name)): 
            bottom[i] += category.name[i].ljust(3)
        # Adding spaces
        for space in range(len(category.name), biggest): 
            bottom[space] += ('   ')
    
    # Iterate over each list item to right align correctly
    everything = []
    for line in compilation+bottom: 
        everything.append(line.rjust(5+width))

    #Join as string and return
    return 'Percentage spent by category\n' + '\n'.join(everything)