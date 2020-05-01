import time
from fileTasks import *
class recursiveHanoi:
    def __init__(self,fileName):
        self.f = fileTask()
        self.fileName = fileName
        self.sumWriteTime = int(0)
        self.sumRunTime = int(0)

    def recHanoi(self, disk,fromRod,toRod,spareRod):
        start = time.perf_counter_ns()
        recursive = recursiveHanoi(self.fileName)
        if disk ==1 :
            self.sumWriteTime = self.f.fileWrite(self.fileName,"Move disk 1 from rod "+fromRod+" to rod "+toRod + "\n") + self.sumWriteTime
        else:

            recursive.recHanoi(disk-1,fromRod,spareRod,toRod)
            self.sumWriteTime = self.f.fileWrite(self.fileName,"Move Disk "+str(disk)+" from rod "+fromRod+" to rod " + toRod+ "\n") + self.sumWriteTime
            recursive.recHanoi(disk-1,spareRod,toRod,fromRod) 

        end = time.perf_counter_ns()
        self.sumRunTime = (end-start) + self.sumRunTime 
        return self.sumRunTime - self.sumWriteTime
