def add_time(start, dur, day=None):
    daysDict = {'Monday': 1, 'Tuesday': 2, 'Wednesday': 3, 'Thursday': 4,
                'Friday': 5, 'Saturday': 6, 'Sunday': 7}
    added = 0
    components = start.split()
    ampm = components[1]
    startTime = components[0].split(':')
    durTime = dur.split(':')
    
    minutes = int(startTime[1]) + int(durTime[1])
    if minutes > 60: 
      added = 1
      minutes -= 60
    minutes = str(minutes).rjust(2, '0')
        
        
    hours = int(startTime[0]) + int(durTime[0]) + added 
    days = hours // 24 
    hours = hours - 24*days
    if hours >= 12: 
        if 'AM' in start: 
          ampm = 'PM'
        if 'PM' in start: 
          ampm = 'AM'
          days += 1 
        if hours > 12: 
          hours -= 12

            
    if day: 
        startDay = day.lower().capitalize()
        endDay = daysDict[startDay] + days
        if endDay > 7: 
          endDay = endDay % 7
        for key, value in daysDict.items(): 
          if endDay == value: 
            endDay = key
            break
        return {
                0: '{}:{} {}, {}',
                1: '{}:{} {}, {} (next day)',
                2: '{}:{} {}, {} ({days} days later)'}[min(2, days)].format(hours, minutes, ampm, endDay, days=days)
    
    return {
            0: '{}:{} {}',
            1: '{}:{} {} (next day)',
            2: '{}:{} {} ({days} days later)'}[min(2, days)].format(hours, minutes, ampm, days=days)