#!/usr/bin/env bash
webHeader="http://"
ipLine=$(ifconfig en0   | grep   "inet" | grep "broadcast" | grep "10")
deleteRightIpLine=${ipLine% n*}
ipResult=${deleteRightIpLine#* }
echo ${ipResult}
fullWebAddress=${webHeader}${ipResult}/apk/
echo ${fullWebAddress}
open ${fullWebAddress}