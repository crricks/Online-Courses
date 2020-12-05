# Part B: Problem 4: TreatedPatient Class
# 10.0/10.0 points (graded)

# We also need a representation for a patient that accounts for the use of drug treatments and manages a collection of ResistantVirus instances. 
# For this, we introduce the TreatedPatient class, which is a subclass of Patient. TreatedPatient must make use of the new methods in ResistantVirus 
# and maintain the list of drugs that are administered to the patient.

# Drugs are given to the patient using the TreatedPatient class's addPrescription() method. What happens when a drug is introduced? The drugs we 
# consider do not directly kill virus particles lacking resistance to the drug, but prevent those virus particles from reproducing (much like actual 
# drugs used to treat HIV). Virus particles with resistance to the drug continue to reproduce normally. Implement the TreatedPatient class.
# Hint: reproduce function child resistances

# Note: If you want to use numpy arrays, you should add the following lines at the beginning of your code for the grader:
# import os
# os.environ["OPENBLAS_NUM_THREADS"] = "1"
# Then, do import numpy as np and use np.METHOD_NAME in your code.

#
# PROBLEM 4
#
def simulationWithDrug(numViruses, maxPop, maxBirthProb, clearProb, resistances,
                       mutProb, numTrials):
    """
    Runs simulations and plots graphs for problem 5.

    For each of numTrials trials, instantiates a patient, runs a simulation for
    150 timesteps, adds guttagonol, and runs the simulation for an additional
    150 timesteps.  At the end plots the average virus population size
    (for both the total virus population and the guttagonol-resistant virus
    population) as a function of time.

    numViruses: number of ResistantVirus to create for patient (an integer)
    maxPop: maximum virus population for patient (an integer)
    maxBirthProb: Maximum reproduction probability (a float between 0-1)        
    clearProb: maximum clearance probability (a float between 0-1)
    resistances: a dictionary of drugs that each ResistantVirus is resistant to
                 (e.g., {'guttagonol': False})
    mutProb: mutation probability for each ResistantVirus particle
             (a float between 0-1). 
    numTrials: number of simulation runs to execute (an integer)
    
    """
    totPop, resistPop = [], []
    for trial in range(numTrials): 
        viruses = [ResistantVirus(maxBirthProb, clearProb, resistances, mutProb) for virus in range(numViruses)]
        janeDoe = TreatedPatient(viruses, maxPop)
        for step in range(300):
            if trial == 0: 
                totPop.append(janeDoe.update())
                resistPop.append(janeDoe.getResistPop(['guttagonol']))
            if step == 150: 
                janeDoe.addPrescription('guttagnol')
            totPop[step] += janeDoe.update()
            resistPop[step] += janeDoe.getResistPop(['guttagonol'])
            
    totPop = [i/numTrials for i in totPop]
    resistPop = [i/numTrials for i in resistPop]
    
    pylab.plot(totPop, label = "Total Pop")
    pylab.plot(resistPop, label = "Resistant Pop")
    pylab.title("SimpleVirus simulation")
    pylab.xlabel("Time Steps")
    pylab.ylabel("Average Virus Population")
    pylab.legend(loc = "best")
    pylab.show()
