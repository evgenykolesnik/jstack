#!/bin/bash

function test {
  description=$1
  command=$2

  echo "Running '$description' test"
  $command > /dev/null &
  pid=$!

  sleep 1

  count=$(jstack $pid | grep -c "Java-level deadlock")
  kill -9 "$pid"

  if [[ "$count" == "0" ]]; then
    echo "Test passed"
  else
    echo "Test failed"
  fi
}

test "Normal mode"   "java -cp target/classes ru.kolesnik.Main normal"
test "Deadlock mode" "java -cp target/classes ru.kolesnik.Main deadlock"
