import time
import math
from fileTasks import *

class iterativeHanoi:
        def __init__(self,fileName,diskNum):
            self.f = fileTask()
            self.fileName = fileName
            self.sumWriteTime = int(0)
            self.sumRunTime = int(0)
            self.source = []
            self.desto = []
            self.spare = []
            self.desto.append(-1)
            self.source.append(-1)
            self.spare.append(-1)
            self.numDisks = diskNum
            for i in range(diskNum):
                self.source.append(i)
            self.source.reverse()
            
        
        def moveDisk(self,s,d):
            if(len(self.source) == 0):
                self.source.append(-1)
            if(len(self.desto) == 0):
                self.desto.append(-1)

            rodSTop = self.source.pop()
            rodDTop = self.desto.pop()

            start = time.perf_counter_ns()

            if(rodSTop == -1 & rodDTop == -1):
                end = time.perf_counter_ns()
                return (end-start)
            else:
                if(rodSTop == -1):
                    self.source.append(rodDTop)
                    self.sumWriteTime = self.f.fileWrite(self.fileName, "Move disk " + str(rodDTop) + 
                        " from rod " +  d + " to rod " + s + "\n") + self.sumWriteTime

                elif(rodDTop == -1):
                    self.desto.append(rodSTop)
                    self.sumWriteTime = self.f.fileWrite(self.fileName, "Move disk " + str(rodSTop) + 
                        " from rod " + s + " to rod " + d + "\n") + self.sumWriteTime

                elif(rodSTop > rodDTop):
                    self.source.append(rodSTop)
                    self.source.append(rodDTop)
                    self.sumWriteTime = self.f.fileWrite(self.fileName, "Move disk " + str(rodDTop) + 
                        " from rod " +  d + " to rod " + s + "\n") + self.sumWriteTime

                elif(rodSTop < rodDTop):
                    self.desto.append(rodDTop)
                    self.desto.append(rodSTop)
                    self.sumWriteTime = self.f.fileWrite(self.fileName, "Move disk " + str(rodSTop) + 
                        " from rod " +  s + " to rod " + d + "\n") + self.sumWriteTime
                
                else:
                    print("HERE")
                    RuntimeError("Error moving disk")

                end = time.perf_counter_ns()
                return (end-start)



        
        def solve(self):
            totalMoves = math.pow(2,self.numDisks) -1
            s = 'S'
            d = 'D'
            a = 'A'

            if(self.numDisks%2 == 0):
                tmp = d
                d = a
                a = tmp

            for i in range(int(totalMoves)):
                if(i%3 == 1):
                    self.sumRunTime = self.moveDisk(s,d) + self.sumRunTime
                elif(i%3==2):
                    self.sumRunTime = self.moveDisk(s,a) + self.sumRunTime
                elif(i%3 == 0):
                    self.sumRunTime = self.moveDisk(a,d) + self.sumRunTime
                else:
                    RuntimeError("Could no move rods")

            return(self.sumRunTime - self.sumWriteTime)


