###########################
# 6.00.2x Problem Set 1: Space Cows 

from ps1_partition import get_partitions
import time

#================================
# Part A: Transporting Space Cows
#================================

def load_cows(filename):
    """
    Read the contents of the given file.  Assumes the file contents contain
    data in the form of comma-separated cow name, weight pairs, and return a
    dictionary containing cow names as keys and corresponding weights as values.

    Parameters:
    filename - the name of the data file as a string

    Returns:
    a dictionary of cow name (string), weight (int) pairs
    """

    cow_dict = dict()

    f = open(filename, 'r')
    
    for line in f:
        line_data = line.split(',')
        cow_dict[line_data[0]] = int(line_data[1])
    return cow_dict


# Problem 1
def greedy_cow_transport(cows,limit=10):
    """
    Uses a greedy heuristic to determine an allocation of cows that attempts to
    minimize the number of spaceship trips needed to transport all the cows. The
    returned allocation of cows may or may not be optimal.
    The greedy heuristic should follow the following method:

    1. As long as the current trip can fit another cow, add the largest cow that will fit
        to the trip
    2. Once the trip is full, begin a new trip to transport the remaining cows

    Does not mutate the given dictionary of cows.

    Parameters:
    cows - a dictionary of name (string), weight (int) pairs
    limit - weight limit of the spaceship (an int)
    
    Returns:
    A list of lists, with each inner list containing the names of cows
    transported on a particular trip and the overall list containing all the
    trips
    """
    # Create copy of cows dictionary
    cowsCopy = sorted(cows.items(), key=lambda x: x[1], reverse=True)
    # Empy transport list
    trip = []
    # Copy the cowsCopy in order to remove cows while still iterating over original copy
    cowTime = cowsCopy[:]
    # Iterate over cows 
    while cowsCopy:
        ship = []
        totalWeight = 0
        for cow in cowsCopy: 
        # Check to see if cow's weight keeps totalWeight under limit
            if totalWeight + cow[1] <= limit: 
                # Update totalWeight
                totalWeight += cow[1]
                # Add cow to trip
                ship.append(cow[0])
                cowTime.remove(cow)
        # Add previous ship to trip
        trip.append(ship)
        # Update cowsCopy to new removed list to iterate over 
        cowsCopy = cowTime[:]
    return trip


# Problem 2
def brute_force_cow_transport(cows,limit=10):
    """
    Finds the allocation of cows that minimizes the number of spaceship trips
    via brute force.  The brute force algorithm should follow the following method:

    1. Enumerate all possible ways that the cows can be divided into separate trips
    2. Select the allocation that minimizes the number of trips without making any trip
        that does not obey the weight limitation
            
    Does not mutate the given dictionary of cows.

    Parameters:
    cows - a dictionary of name (string), weight (int) pairs
    limit - weight limit of the spaceship (an int)
    
    Returns:
    A list of lists, with each inner list containing the names of cows
    transported on a particular trip and the overall list containing all the
    trips
    """
    # Create copy of cows dictionary
    cowsCopy = cows.copy()
    # Set smallest number of ships to be largest trip length; i.e. one cow per ship
    smallest = len(cowsCopy)
    # Get trip from get_partitions and use for loop to go through
    for trip in get_partitions(cowsCopy):
        # Iterate over each ship in the trip
        for ship in trip:
            # Set totalWeight to zero
            totalWeight = 0
            # For each cow, count the weight added
            for cow in ship: 
                totalWeight += cowsCopy[cow]
            # If the ship is over capacity, break and find a new trip
            if totalWeight > limit:
                break
        # If totalWeight is below the limit for all ships and it is the fewest amount of ships
        if totalWeight <= limit and len(trip) <= smallest: 
            posTrip = trip[:]
            smallest = len(trip)
    return posTrip

        
# Problem 3
def compare_cow_transport_algorithms():
    """
    Using the data from ps1_cow_data.txt and the specified weight limit, run your
    greedy_cow_transport and brute_force_cow_transport functions here. Use the
    default weight limits of 10 for both greedy_cow_transport and
    brute_force_cow_transport.
    
    Print out the number of trips returned by each method, and how long each
    method takes to run in seconds.

    Returns:
    Does not return anything.
    """
    cows = load_cows("ps1_cow_data.txt")
    greedystart = time.time()
    greedy = greedy_cow_transport(cows)
    greedyend = time.time()
    
    brutestart = time.time()
    brute = brute_force_cow_transport(cows)
    bruteend = time.time()
    return 'Greedy Time: ' + str(greedyend) + '\nLength of trip: ' + str(len(greedy))\
        + '\nBrute Force Time: ' + str(bruteend) + '\nLength of trip: ' + str(len(brute))
    
    
    


"""
Here is some test data for you to see the results of your algorithms with. 
Do not submit this along with any of your answers. Uncomment the last two
lines to print the result of your problem.
"""

cows = load_cows("ps1_cow_data.txt")
limit=100
print(cows)

print(greedy_cow_transport(cows, limit))
print(brute_force_cow_transport(cows, limit))
