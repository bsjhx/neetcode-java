#!/bin/bash

YEAR=$1
DAY=$2

if [ -z "$YEAR" ] || [ -z "$DAY" ]; then
  echo "Usage: ./generate_day.sh <year> <day>"
  exit 1
fi

DAY_PADDED=$(printf "%02d" "$DAY")

MAIN_JAVA_DIR="src/main/java/pl/bsjhx/katas/adventofcode/year${YEAR}"
TEST_JAVA_DIR="src/test/java/pl/bsjhx/katas/adventofcode/year${YEAR}"
MAIN_RES_DIR="src/main/resources/adventofcode2025"
TEST_RES_DIR="src/test/resources/adventofcode2025"

MAIN_CLASS="Day${DAY_PADDED}_${YEAR}"
TEST_CLASS="Day${DAY_PADDED}_${YEAR}Test"

# Create directories
mkdir -p "$MAIN_JAVA_DIR"
mkdir -p "$TEST_JAVA_DIR"
mkdir -p "$MAIN_RES_DIR"
mkdir -p "$TEST_RES_DIR"

# Main Java file
cat <<EOF > "$MAIN_JAVA_DIR/${MAIN_CLASS}.java"
package pl.bsjhx.katas.adventofcode.year${YEAR};

import pl.bsjhx.katas.adventofcode.Advent;

import java.io.IOException;

public class ${MAIN_CLASS} implements Advent {

    @Override
        public long calculatePartOne() throws IOException {
            return Advent.super.calculatePartTwo();
        }

        @Override
        public long calculatePartTwo() throws IOException {
            return Advent.super.calculatePartOne();
        }
}
EOF

# Test Java file
cat <<EOF > "$TEST_JAVA_DIR/${TEST_CLASS}.java"
package pl.bsjhx.katas.adventofcode.year${YEAR};

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ${TEST_CLASS} {

    @Test
    void test() throws IOException {
        assertEquals(0L, new ${MAIN_CLASS}().calculatePartOne());
        assertEquals(0L, new ${MAIN_CLASS}().calculatePartTwo());
    }
}
EOF

# Input files (no leading zero)
echo "$MAIN_RES_DIR/day${DAY}.txt"
touch "$MAIN_RES_DIR/day${DAY}.txt"
touch "$TEST_RES_DIR/day${DAY}.txt"

echo "Generated files for year ${YEAR}, day ${DAY}"
