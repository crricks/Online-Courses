def arithmetic_arranger(problems, d=False):  

    # Length error message
    if len(problems) > 5: 
        return 'Error: Too many problems.'
    
    # Create empty lists for each category
    masterTop, masterBottom, masterLine, masterResult = [], [], [], []
  
    # Iterate over problems
    for prob in problems: 
        # Split problem in components
        items = prob.split()
            
        # Correct length check
        if len(items[0]) > 4 or len(items[2]) > 4:
            return 'Error: Numbers cannot be more than four digits.'

        # Get longest number to calculate amount of spaces needed
        longestNumb = max(len(items[0]), len(items[2]))
        
        # Compile top section and enter into list
        spaceTop = (longestNumb - len(items[0]))*' '
        top = spaceTop + '  ' + items[0]
        masterTop.append(top)
        
        # Compile bottom section and enter into list
        spaceBottom = (longestNumb - len(items[2]))*' '
        bottom = items[1] + ' ' + spaceBottom + items[2]
        masterBottom.append(bottom)
        
        # Compile line
        line = '-'*len(bottom)
        masterLine.append(line)
        
        # Make sure numbers only contain digits
        try:
            topNumb = int(items[0])
            bottomNumb = int(items[2])
        except:
            return 'Error: Numbers must only contain digits.'
            
        # Do addition or subtraction
        if items[1] == '+':
            result = str(topNumb + bottomNumb)
        elif items[1] == '-':
            result = str(topNumb - bottomNumb)
        else: 
            return "Error: Operator must be '+' or '-'."
        
        # Compile result section and enter into list
        spaceResult = (len(line)-len(result))*' '
        result = spaceResult + result
        masterResult.append(result)

    # Join each list with appropriate padding in between
    joinMaster = '    '.join(masterTop)
    joinBottom = '    '.join(masterBottom)
    joinLine = '    '.join(masterLine)
    joinResult = '    '.join(masterResult)
    
    # If second argument is True, include results in arranged_problems
    if d == True:
        arranged_problems = joinMaster + '\n' + joinBottom + '\n' + joinLine + '\n' + joinResult
    
    if d == False:
        arranged_problems = joinMaster + '\n' + joinBottom + '\n' + joinLine
    
    return arranged_problems
