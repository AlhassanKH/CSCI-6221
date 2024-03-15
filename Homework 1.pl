#!/usr/bin/perl

# Write a function in any programming language that will demonstrate dynamic scoping. The function should be executable. Please indicate what’s the programming language used in your answer. 

use strict;
use warnings;

my $name = "Global Name";

sub showName {
    print "Name: $name\n";
}

sub dynamicScopeTest {
    local $name = "Local Name";
    showName(); # This will print "Local Name" due to dynamic scoping
}

dynamicScopeTest(); # Outputs: "Local Name"
showName();         # Outputs: "Global Name"
