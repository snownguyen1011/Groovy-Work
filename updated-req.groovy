

def file1 = readProperties("${WORKSPACE}/inputfile1.properties")  // Converts as a String
println(file1.getClass())  // file1 is a string
def inputlist = []
println(file1.tokenize("="))