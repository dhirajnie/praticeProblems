#!/bin/bash
VAR="global"

function fun {
local VAR="local var"
echo $VAR
}
echo $VAR
fun
echo $VAR



echo $1



echo `uname -o`

trap mytrap INT
# Overiding trap behaviour
mytrap() {
echo "ctr+c detected"

}
for a in `seq 1 3`; do
    echo "$a/10 to Exit."
    sleep 1;
done
echo "Exit Bash Trap Example!!!"


ARRAY=("qwq" "bss" 1)
echo ${ARRAY[@]}

ELEMENTS=${#ARRAY[@]}
for((i=0;i<$ELEMENTS;i++));do
    echo ${ARRAY[${i}]}
done
echo -e "Linear search start input array:"
read -a arr
echo ${arr[@]}

echo  -e "Key to search"

read key
declare found=false
for((i=0;i<${#arr[@]};i++));do
    if [[ ${arr[$i]} == $key ]]; then
        found=true
        echo "Ffound"
    fi
done

if [[ $found == false  ]]; then
echo "Not found"
fi


select word in "linux" "bash" "scripting" "tutorial"
do
  echo "The word you have selected is: $word"
# Break, otherwise endless loop
 break
done

echo $word

read cas
case $cas in
    1) echo "You selected bash";;
    2) echo "You selected perl";;
    3) echo "You selected phyton";;
    4) echo "You selected c++";;
    5) exit
esac



