#!/usr/bin/env bash

set -eo pipefail

mvn clean package

version=$(git rev-parse HEAD)
image_tag="user-web:${version}"
latest_image_tag='user-web:latest'

docker build -t "${image_tag}" -t "${latest_image_tag}" .