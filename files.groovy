def textFile = new File('poem.txt')
textFile.append('What\'s in a name? ')
textFile.append('That which we call a rose\n')
textFile.append('By any other name would smell as sweet.\n')
println textFile.text

println new Date().format('yyyy-MM-dd')