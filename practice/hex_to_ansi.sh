#!/bin/bash

function hex_to_ansi_electro(){
	# Get the individual color components as decimals
	HEX=$(echo "$1" | tr -d '#' | tr '[:lower:]' '[:upper:]')
	DIGITS=$(( ${#HEX} / 3 ))
	R=$(( 16#${HEX:$(( DIGITS * 0 )):$DIGITS} ))
	G=$(( 16#${HEX:$(( DIGITS * 1 )):$DIGITS} ))
	B=$(( 16#${HEX:$(( DIGITS * 2 )):$DIGITS} ))

	# Handle grey ramp
	if [ "`echo $(( R-G )) | tr -d '-'`" -lt 16 ]\
			&& [ "`echo $(( R-B )) | tr -d '-'`" -lt 16 ]\
			&& [ "`echo $(( G-B )) | tr -d '-'`" -lt 16 ]; then
		GREY=$(( (R+G+B)/3 ))
		if [ "$GREY" -lt 5 ]; then CC="0"
		elif [ "$GREY" -gt 246 ]; then CC=15
		else CC=$(( (GREY-3)/10 + 232 )); fi

	# Handle 16 basic colors
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC="0"
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=1
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=2
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=3
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=4
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=5
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=6
	elif [ "`echo $(( R-192 )) | tr -d '-'`" -lt 18 ]\
			&& [ "`echo $(( G-192 )) | tr -d '-'`" -lt 18 ]\
			&& [ "`echo $(( B-192 )) | tr -d '-'`" -lt 18 ]; then
		CC=7
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=8
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=9
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=10
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=11
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=12
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=13
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=14
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=15

	# Handle 6x6x6 color cube
	else
		CC=16
		if [ "$R" -lt 48 ]; then :
		elif [ "$R" -lt 115 ]; then CC=$(( CC+(36*1) ))
		elif [ "$R" -lt 156 ]; then CC=$(( CC+(36*2) ))
		elif [ "$R" -lt 196 ]; then CC=$(( CC+(36*3) ))
		elif [ "$R" -lt 235 ]; then CC=$(( CC+(36*4) ))
		else CC=$(( CC+(36*5) )); fi
		if [ "$G" -lt 48 ]; then :
		elif [ "$G" -lt 115 ]; then CC=$(( CC+(6*1) ))
		elif [ "$G" -lt 156 ]; then CC=$(( CC+(6*2) ))
		elif [ "$G" -lt 196 ]; then CC=$(( CC+(6*3) ))
		elif [ "$G" -lt 235 ]; then CC=$(( CC+(6*4) ))
		else CC=$(( CC+(6*5) )); fi
		if [ "$B" -lt 48 ]; then :
		elif [ "$B" -lt 115 ]; then CC=$(( CC+1 ))
		elif [ "$B" -lt 156 ]; then CC=$(( CC+2 ))
		elif [ "$B" -lt 196 ]; then CC=$(( CC+3 ))
		elif [ "$B" -lt 235 ]; then CC=$(( CC+4 ))
		else CC=$(( CC+5 )); fi
	fi

	# Use the color for either background or foreground
	if [ -z "$2" ]; then
		echo "[38;5;"$CC"m" > foreground_electro.txt
	else
		echo "[48;5;"$CC"m" > background_electro.txt
	fi
}

# Call the function with an electro hex color code
hex_to_ansi_electro "#d376f0"
# Call the function with a electro hex color code and background flag
hex_to_ansi_electro "#d376f0" "background"

function hex_to_ansi_pyro(){
	# Get the individual color components as decimals
	HEX=$(echo "$1" | tr -d '#' | tr '[:lower:]' '[:upper:]')
	DIGITS=$(( ${#HEX} / 3 ))
	R=$(( 16#${HEX:$(( DIGITS * 0 )):$DIGITS} ))
	G=$(( 16#${HEX:$(( DIGITS * 1 )):$DIGITS} ))
	B=$(( 16#${HEX:$(( DIGITS * 2 )):$DIGITS} ))

	# Handle grey ramp
	if [ "`echo $(( R-G )) | tr -d '-'`" -lt 16 ]\
			&& [ "`echo $(( R-B )) | tr -d '-'`" -lt 16 ]\
			&& [ "`echo $(( G-B )) | tr -d '-'`" -lt 16 ]; then
		GREY=$(( (R+G+B)/3 ))
		if [ "$GREY" -lt 5 ]; then CC="0"
		elif [ "$GREY" -gt 246 ]; then CC=15
		else CC=$(( (GREY-3)/10 + 232 )); fi

	# Handle 16 basic colors
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC="0"
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=1
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=2
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=3
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=4
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=5
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=6
	elif [ "`echo $(( R-192 )) | tr -d '-'`" -lt 18 ]\
			&& [ "`echo $(( G-192 )) | tr -d '-'`" -lt 18 ]\
			&& [ "`echo $(( B-192 )) | tr -d '-'`" -lt 18 ]; then
		CC=7
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=8
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=9
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=10
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=11
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=12
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=13
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=14
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=15

	# Handle 6x6x6 color cube
	else
		CC=16
		if [ "$R" -lt 48 ]; then :
		elif [ "$R" -lt 115 ]; then CC=$(( CC+(36*1) ))
		elif [ "$R" -lt 156 ]; then CC=$(( CC+(36*2) ))
		elif [ "$R" -lt 196 ]; then CC=$(( CC+(36*3) ))
		elif [ "$R" -lt 235 ]; then CC=$(( CC+(36*4) ))
		else CC=$(( CC+(36*5) )); fi
		if [ "$G" -lt 48 ]; then :
		elif [ "$G" -lt 115 ]; then CC=$(( CC+(6*1) ))
		elif [ "$G" -lt 156 ]; then CC=$(( CC+(6*2) ))
		elif [ "$G" -lt 196 ]; then CC=$(( CC+(6*3) ))
		elif [ "$G" -lt 235 ]; then CC=$(( CC+(6*4) ))
		else CC=$(( CC+(6*5) )); fi
		if [ "$B" -lt 48 ]; then :
		elif [ "$B" -lt 115 ]; then CC=$(( CC+1 ))
		elif [ "$B" -lt 156 ]; then CC=$(( CC+2 ))
		elif [ "$B" -lt 196 ]; then CC=$(( CC+3 ))
		elif [ "$B" -lt 235 ]; then CC=$(( CC+4 ))
		else CC=$(( CC+5 )); fi
	fi

	# Use the color for either background or foreground
	if [ -z "$2" ]; then
		echo "[38;5;"$CC"m" > foreground_pyro.txt
	else
		echo "[48;5;"$CC"m" > background_pyro.txt
	fi
}

# Call the function with a pyro hex color code 
hex_to_ansi_pyro "#e2311d"
# Call the function with a pyro hex color code and background flag
hex_to_ansi_pyro "#e2311d" "background"

function hex_to_ansi_overloaded(){
	# Get the individual color components as decimals
	HEX=$(echo "$1" | tr -d '#' | tr '[:lower:]' '[:upper:]')
	DIGITS=$(( ${#HEX} / 3 ))
	R=$(( 16#${HEX:$(( DIGITS * 0 )):$DIGITS} ))
	G=$(( 16#${HEX:$(( DIGITS * 1 )):$DIGITS} ))
	B=$(( 16#${HEX:$(( DIGITS * 2 )):$DIGITS} ))

	# Handle grey ramp
	if [ "`echo $(( R-G )) | tr -d '-'`" -lt 16 ]\
			&& [ "`echo $(( R-B )) | tr -d '-'`" -lt 16 ]\
			&& [ "`echo $(( G-B )) | tr -d '-'`" -lt 16 ]; then
		GREY=$(( (R+G+B)/3 ))
		if [ "$GREY" -lt 5 ]; then CC="0"
		elif [ "$GREY" -gt 246 ]; then CC=15
		else CC=$(( (GREY-3)/10 + 232 )); fi

	# Handle 16 basic colors
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC="0"
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=1
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=2
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-0 )) | tr -d '-'`" -lt 24 ]; then
		CC=3
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=4
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=5
	elif [ "`echo $(( R-0 )) | tr -d '-'`" -lt 24 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=6
	elif [ "`echo $(( R-192 )) | tr -d '-'`" -lt 18 ]\
			&& [ "`echo $(( G-192 )) | tr -d '-'`" -lt 18 ]\
			&& [ "`echo $(( B-192 )) | tr -d '-'`" -lt 18 ]; then
		CC=7
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=8
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=9
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=10
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-128 )) | tr -d '-'`" -lt 14 ]; then
		CC=11
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=12
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=13
	elif [ "`echo $(( R-128 )) | tr -d '-'`" -lt 14 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=14
	elif [ "`echo $(( R-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( G-255 )) | tr -d '-'`" -lt 10 ]\
			&& [ "`echo $(( B-255 )) | tr -d '-'`" -lt 10 ]; then
		CC=15

	# Handle 6x6x6 color cube
	else
		CC=16
		if [ "$R" -lt 48 ]; then :
		elif [ "$R" -lt 115 ]; then CC=$(( CC+(36*1) ))
		elif [ "$R" -lt 156 ]; then CC=$(( CC+(36*2) ))
		elif [ "$R" -lt 196 ]; then CC=$(( CC+(36*3) ))
		elif [ "$R" -lt 235 ]; then CC=$(( CC+(36*4) ))
		else CC=$(( CC+(36*5) )); fi
		if [ "$G" -lt 48 ]; then :
		elif [ "$G" -lt 115 ]; then CC=$(( CC+(6*1) ))
		elif [ "$G" -lt 156 ]; then CC=$(( CC+(6*2) ))
		elif [ "$G" -lt 196 ]; then CC=$(( CC+(6*3) ))
		elif [ "$G" -lt 235 ]; then CC=$(( CC+(6*4) ))
		else CC=$(( CC+(6*5) )); fi
		if [ "$B" -lt 48 ]; then :
		elif [ "$B" -lt 115 ]; then CC=$(( CC+1 ))
		elif [ "$B" -lt 156 ]; then CC=$(( CC+2 ))
		elif [ "$B" -lt 196 ]; then CC=$(( CC+3 ))
		elif [ "$B" -lt 235 ]; then CC=$(( CC+4 ))
		else CC=$(( CC+5 )); fi
	fi

	# Use the color for either background or foreground
	if [ -z "$2" ]; then
		echo "[38;5;"$CC"m" > foreground_overloaded.txt
	else
		echo "[48;5;"$CC"m" > background_overloaded.txt
	fi
}

# Call the function with a overloaded hex color code 
hex_to_ansi_overloaded "#da5386"
# Call the function with a overloaded hex color code and background flag
hex_to_ansi_overloaded "#da5386" "background"

pause
