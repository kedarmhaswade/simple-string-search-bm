#!/bin/bash
set -o nounset
set -o errexit
MYDIR=$(dirname $0)
CALIPER_JAR=~/.m2/repository/com/google/caliper/caliper/1.0-beta-SNAPSHOT/caliper-1.0-beta-SNAPSHOT-all.jar
if [[ ! -f ${CALIPER_JAR} ]]; then
  echo "Follow the instructions; build caliper first in a separate folder"
  exit 1
fi
java -ea -server -Xmx2g -Xms2g -cp ${CALIPER_JAR}:${MYDIR}/target/classes com.lithium.bm.StringCmp 400000
