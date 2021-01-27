# Read from the file file.txt and output the tenth line to stdout -.

n=1
while read line
do


if [ $n -eq 10 ]
then
echo "$line"
fi

n=`expr $n + 1`
done < file.txt