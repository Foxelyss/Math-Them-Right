#!/bin/env bash


wine "/home/stephan/.wine/drive_c/Nokia/Devices/S40_6th_Edition_SDK/bin/preverify.exe" $1 ${2//":"/";"} $3 $4 $5
