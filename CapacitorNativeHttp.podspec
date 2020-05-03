
  Pod::Spec.new do |s|
    s.name = 'CapacitorNativeHttp'
    s.version = '0.0.1'
    s.summary = 'Http plugin to connect Angular and devices'
    s.license = 'MIT'
    s.homepage = 'https://github.com/hedesil/capacitor-native-http.git'
    s.author = 'Mariano Moreno Molina'
    s.source = { :git => 'https://github.com/hedesil/capacitor-native-http.git', :tag => s.version.to_s }
    s.source_files = 'ios/Plugin/**/*.{swift,h,m,c,cc,mm,cpp}'
    s.ios.deployment_target  = '11.0'
    s.dependency 'Capacitor'
  end