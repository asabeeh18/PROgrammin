;assume CS:code,DS:data
data segment
	ar db 08h,03h,06h,01h
data ends
code segment
START:
;mov ax,data
;mov DS,ax
			mov cx,4
	UP:		lea si,ar
			mov bx,cx
			mov al,[si]
			mov dl,[si+1]
			cmp al,dl
			jb skip
			xchg al,dl
			mov[si],al
			mov [si+1],dl
	SKIP:   inc si
			dec bx
			jnz up
			int 03h
code ends
end start
	