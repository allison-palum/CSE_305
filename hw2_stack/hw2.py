import sys

class Stack:
	def __init__(self):
		self.items = []
	def isEmpty(self):
		return self.items == []
	def push(self, item):
		self.items.append(item)
	def pop(self):
		return self.items.pop()
	def size(self):
		return len(self.items)

def hw2(input_file, output_file):
	f = open(input_file, 'r')
	read = f.read()
	inp = read.splitlines()
	out = open(output_file, 'r+')
	stack = Stack()
	for s in inp:
		string = s.split()
		if string[0] == "quit":
			length = stack.size()
			while length != 0:
				x = stack.pop()
				length = stack.size()
				out.write(str(x)+"\n")
		elif string[0] == "pop":
			length = stack.size()
			if length == 0:
				stack.push(":error:")
			else:
				stack.pop()
		elif string[0] == ":error:":
			stack.push(":error:")
		elif string[0] == ":false:":
			stack.push(":error:")
		elif string[0] == ":true:":
			stack.push(":true:")
		elif string[0] == "push":
			stack.push(int(string[1]))
		elif string[0] == "add":
			length = stack.size()
			y = stack.pop()
			if length < 2:
				stack.push(y)
				stack.push(":error:")
			elif y != ":error:" and y != ":false:" and y != ":true:":
				x = stack.pop()
				if x != ":error:" and x != ":false:" and x != ":true:":
					add = x + y
					stack.push(int(add))
				else:
					stack.push(x)
					stack.push(y)
					stack.push(":error:")
		elif string[0] == "sub":
			length = stack.size()
			y = stack.pop()
			if length < 2:
				stack.push(y)
				stack.push(":error:")
			elif y != ":error:" and y != ":false:" and y != ":true:":
				x = stack.pop()
				if x != ":error:" and x != ":false:" and x != ":true:":
					sub = x - y
					stack.push(int(sub))
				else:
					stack.push(x)
					stack.push(y)
					stack.push(":error:")
		elif string[0] == "mul":
			length = stack.size()
			y = stack.pop()
			if length < 2:
				stack.push(y)
				stack.push(":error:")
			elif y != ":error:" and y != ":false:" and y != ":true:":
				x = stack.pop()
				if x != ":error:" and x != ":false:" and x != ":true:":
					mul = x * y
					stack.push(int(mul))
				else:
					stack.push(x)
					stack.push(y)
					stack.push(":error:")
		elif string[0] == "div":
			length = stack.size()
			y = stack.pop()
			if length < 2:
				stack.push(y)
				stack.push(":error:")
			elif y != ":error:" and y != ":false:" and y != ":true:":
				x = stack.pop()
				if x != ":error:" and x != ":false:" and x != ":true:":
					div = x / y
					stack.push(int(div))
				else:
					stack.push(x)
					stack.push(y)
					stack.push(":error:")
		elif string[0] == "rem":
			length = stack.size()
			y = stack.pop()
			if length < 2:
				stack.push(y)
				stack.push(":error:")
			elif y != ":error:" and y != ":false:" and y != ":true:":
				x = stack.pop()
				if x != ":error:" and x != ":false:" and x != ":true:":
					rem = x % y
					stack.push(int(rem))
				else:
					stack.push(x)
					stack.push(y)
					stack.push(":error:")
		elif string[0] == "neg":
			length = stack.size()
			y = stack.pop()
			if length < 0:
				stack.push(y)
				stack.push(":error:")
			elif y != ":error:" and y != ":false:" and y != ":true:":
				neg = y * -1
				stack.push(int(neg))
			else:
				stack.push(y)
				stack.push(":error:")
		elif string[0] == "swap":
			length = stack.size()
			if length < 2:
				stack.push(":error:")
			else:
				y = stack.pop()
				x = stack.pop()
				stack.push(y)
				stack.push(x)				
	out.close()
	f.close()
