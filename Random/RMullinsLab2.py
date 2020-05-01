from recursiveHanoi import *
from iterativeHanoi import *
from fileTasks import *
import time

n = 14

fileOut = input("Enter output File: ")

outFile = fileTask()
sumRecuTimes = 0
sumIterTimes = 0
test = recursiveHanoi(fileOut)
testIter = iterativeHanoi(fileOut,n)

for index in range(30):
    start = time.perf_counter_ns()
    iterTime = testIter.solve()
    end = time.perf_counter_ns()
    sumIterTimes = iterTime + sumIterTimes
iterTotalTime = sumIterTimes/index

for i in range(10):
    
    start = time.perf_counter_ns()
    times = test.recHanoi(n,'A','B','C')
    end = time.perf_counter_ns()
    sumRecuTimes = times + sumRecuTimes
times = sumRecuTimes/i
print("Recursive Time: " + str(times))
print("Iterative Time: " + str(iterTotalTime))