package fr.rginfo.philou.pgo.map.alert;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;

@Controller
public class AlertController {

  private final AlertRepository alertRepository;

  @Inject
  public AlertController(AlertRepository alertRepository) {
    this.alertRepository = alertRepository;
  }

  @RequestMapping({"/", "/configuration"})
  public String getConfigurationPage(final Model model) {
    AlertBean bean = alertRepository.findAll().isEmpty() ? new AlertBean() : alertRepository.findAll().get(0);
    model.addAttribute("alert", bean);

    return "configuration";
  }

  @RequestMapping(value="/save-alert")
  public String saveConfiguration(final AlertBean alert, final BindingResult bindingResult, final ModelMap model) {
    alertRepository.save(alert);
    model.addAttribute("alert", alert);
    return "redirect:/configuration";
  }

}
