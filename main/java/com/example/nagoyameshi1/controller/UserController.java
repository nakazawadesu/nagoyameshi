package com.example.nagoyameshi1.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.nagoyameshi1.model.User;
import com.example.nagoyameshi1.repository.UserRepository;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // 会員登録フォームを表示
    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User()); // 空のUserを渡す
        return "register"; // register.html を返す
    }

    // 入力データを受け取り保存
    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
    	user.setPassword(passwordEncoder.encode(user.getPassword())); // ← ここで暗号化
        userRepository.save(user); // DBに保存
        return "redirect:/register-success"; // 登録完了ページへリダイレクト
    }

    // 登録完了ページ
    @GetMapping("/register-success")
    public String registerSuccess() {
        return "register-success";
    }
}
