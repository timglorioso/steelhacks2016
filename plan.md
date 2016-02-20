# Image Color Matcher

## Use Case

1. user takes/imports photos
2. user selects desired areas to match

## Matching

1. determine HSL representation of selected areas
2. calculate matching colors based on color theory relationships
3. compare all selected areas to find "best fit"

## Input/Output

in: any number of images, one of which is the control
out: a list of images ranked by percentage of match
