//
//  CircularProgressBar.swift
//  iosApp
//
//  Created by MacBook on 01.10.2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct CircularProgressView: View {
    @State private var progress: CGFloat = 0.0
    let timer = Timer.publish(every: 0.003, on: .main, in: .common).autoconnect()

    var body: some View {
        ZStack {
            Circle()
                .stroke(Color.gray.opacity(0.2), style: StrokeStyle(lineWidth: 10, lineCap: .round))
                .frame(width: 100, height: 100)

            Circle()
                .trim(from: 0, to: progress)
                .stroke(Color(hex: 0xFF40BF6A), style: StrokeStyle(lineWidth: 10, lineCap: .round))
                .frame(width: 100, height: 100)
                .rotationEffect(.degrees(-90))

            Text("\(Int(progress * 100))%")
                .font(.headline)
                .bold()
                .foregroundColor(Color(hex: 0xFFEEEEEE))
        }
        .onReceive(timer) { _ in
            if progress < 1.0 {
                progress += 0.01
            }
        }
    }
}

