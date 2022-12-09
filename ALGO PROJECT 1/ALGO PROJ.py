import os
import time

#Brute force algorithm
def brute_force(pattern,text):
    time1 = time.time()
    count = 0
    position = []
    for i in range(len(text)-len(pattern)+1):
        length = 0
        for j in range(len(pattern)):
            if text[i+j] == pattern[j]:
                length+=1
        if(length==len(pattern)):
            position.append(i)
    time2 = time.time()
    t = time2-time1
    return position

def naive(p,t):
    time1 = time.time()
    count = 0
    for i in range(len(t)-len(p)+1):
        match = True
        for j in range(len(p)):
            if t[i+j] != p[j]:
                match = False
                break
        if match:
            count+=1
    time2 = time.time()
    t = time2-time1
    return count,t

def twojump(pattern,text):
    time1 = time.time()
    position = []
    #preprocessing
    index = []
    for i in range(len(text)-len(pattern)+1):
        if text[i] == pattern[0]:
            index.append(i)
    time2 = time.time()

    #comparison

    for j in index:
        length = 0
        for k in range(len(pattern)):
            if text[j+k] != pattern[k]:
                break
            else:
                length+=1
        if(length==len(pattern)):
            position.append(j)
    time3 = time.time()

    t = time3-time1
    return position

def kmp_matcher(pattern,text):
    t1 = time.time()
    # computing the longest prefix and suffix
    longest_pref_suff = []
    longest_pref_suff.append(0)
    i = 1
    j = 0
    while i<len(pattern):
        if(pattern[i]==pattern[j]):
            i +=1
            longest_pref_suff.append(j+1)
            j+=1

        elif(j!=0):
            j = longest_pref_suff[j-1]
        else:
            i +=1
            longest_pref_suff.append(0)
    text_pointer = 0
    pattern_pointer = 0
    position = []
    while (text_pointer<len(text)) :
        if (pattern_pointer<len(pattern) and text[text_pointer] == pattern[pattern_pointer] ):
            text_pointer += 1
            pattern_pointer += 1

        elif (pattern_pointer == len(pattern) ):
            position.append(text_pointer-pattern_pointer)
            pattern_pointer = longest_pref_suff[pattern_pointer-1]
        else :
            if (pattern_pointer!=0):
                pattern_pointer = longest_pref_suff[pattern_pointer-1]
            else:
                text_pointer+=1
    t2= time.time()
    t3 = t2-t1
    return position



def read_file():
    file = input("Enter the file directory\n")
    f = open(os.path.abspath(file),"r")
    text = ""
    for line in f:
        if(line[0]==">"):
            continue
        else:
            text += line;
    f.close()
    return  (text.replace("\n",""))



text = read_file()
pattern = input("Enter the pattern to find\n")
choice = int(input("Enter your choice\n"
                   "1. BruteForce ALgorithm\n"
                   "2. KNP Algorithm\n"
                   "3. Index Jump Algorithm\n"))
if(choice==1):
    pos = brute_force(pattern,text)
    for i in pos:
        print("the indexes are",i)
elif(choice==2):
    print(len(kmp_matcher(pattern,text)))
else:
    print(twojump(pattern, text))

