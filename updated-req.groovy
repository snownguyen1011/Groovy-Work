
def file = new File("./inputfile1.properties")
line = 'speciality-order'

println(file.find(line))


def file1 = readFile("./inputfile1.properties")
file.get