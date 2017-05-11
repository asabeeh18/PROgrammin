pyg = 'ay'

original = raw_input('Enter a word:')
ch=original[0]
st=original[1:len(original)]+ch+pyg
if len(original) > 0 and original.isalpha():
    print st
else:
    print 'empty'