import sys

def hw1(input_file, output_file):
	#read input file
	#for every line in input file, check if pangram
	#write result to output file	
	f = open(input_file, 'r')
	read = f.read()
	inp = read.splitlines()
	out = open(output_file, 'r+') 
	alphabetList = 'abcdefghijklmnopqrstuvwxyz'
	alphabetCount = 0
	for s in range(len(inp)):	
		string = list(inp[s])
		if len(string) < 26:
			out.write('false\n')
		else:
			for i in range(len(alphabetList)):
				if alphabetList[i] in string:
					alphabetCount = alphabetCount + 1
			if alphabetCount == 26:
				out.write('true\n')
			else: 
				out.write('false\n')
		alphabetCount = 0
	out.close()
	f.close()
