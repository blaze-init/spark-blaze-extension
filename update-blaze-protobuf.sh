#!/bin/bash

set -e
set -x

git_branch="${1:-master}"
proto_url="https://raw.githubusercontent.com/blaze-init/blaze-rs/$git_branch/plan-serde/proto/plan.proto"

proto_path="$PWD/src/main"
proto_location="$proto_path/proto/plan.proto"

wget -O "$proto_location" "$proto_url"
