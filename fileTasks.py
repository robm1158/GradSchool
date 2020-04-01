import time

class fileTask:
    
    def fileWrite(self,fileName,contents):
        start = time.perf_counter_ns()
        f =open(fileName,"a")
        f.write(contents)
        f.close()
        end = time.perf_counter_ns()
        return(end-start)
