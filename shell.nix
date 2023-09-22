{ system ? builtins.currentSystem }:

with (import (fetchTarball {
  name = "nixpkgs-23.05";
  url = "https://github.com/nixos/nixpkgs/archive/23.05.tar.gz";
  sha256 = "10wn0l08j9lgqcw8177nh2ljrnxdrpri7bp0g7nvrsn9rkawvlbf";
}) { inherit system; });

let
  requiredNixVersion = "2.3";

  pwd = builtins.getEnv "PWD";
in

assert lib.asserts.assertMsg (lib.versionOlder builtins.nixVersion requiredNixVersion == false) ''
  This project requires Nix >= ${requiredNixVersion}, but ${builtins.nixVersion} is installed.
  Please run 'nix-channel --update && nix-env -i nix'.
'';

  mkShell {
    buildInputs = [
      stdenv
      cacert
      gnupg

      # Java/Clojure dependencies
      jdk8
      (leiningen.override { jdk = openjdk8; })
    ];

    NIX_PROJECT = builtins.baseNameOf pwd;
}
