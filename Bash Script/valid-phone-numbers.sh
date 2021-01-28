# Read from the file file.txt and output all valid phone numbers to stdout.


#\d refer to one digit and {3} appear three times

grep -P '^(\d{3}-\d{3}-\d{4}|\(\d{3}\) \d{3}-\d{4})$' file.txt
        
    