fun hw1(inFile:string, outFile:string) = 
	let
		val inStream = TextIO.openIn inFile
		val outStream = TextIO.openOut outFile
		val readLine = TextIO.inputLine inStream
		fun helper(readLine: string option) =
			let 
				fun isPangram(str: string, i: int) =
					let
						val alphabet = "abcdefghijklmnopqrstuvwxyz"
					in	
						if Char.contains str(String.sub(alphabet, i)) then 
							( if i+1 = 26 then "true\n"
							  else isPangram(str, i+1) )
						else "false\n"
													
					end
											
			in
				case readLine of
					NONE => ( TextIO.closeIn inStream; TextIO.closeOut outStream)
					| SOME(c) => (TextIO.output(outStream, isPangram(c, 0));
					helper(TextIO.inputLine inStream))
			end
	in
		helper(readLine)
	end;	
